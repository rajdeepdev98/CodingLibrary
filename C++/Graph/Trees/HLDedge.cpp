// HLD implementation for max along a path in a tree
void dfs_size(int s,int p,int ed){
 
    dis[s]=dis[p]+1;
    // tin[s]=++cnt;
    up[s][0]=p;
    
     for(int i=1;i<21;i++){
 
        up[s][i]=up[up[s][i-1]][i-1];//binary lifting
 
    }
    siz[s]=1;
    int bigv=-1,bigc=-1,bige=-1;
    for(auto el:graph[s]){
 
        if(el.ff==p)continue;
        dfs_size(el.ff,s,el.ss);
        siz[s]+=siz[el.ff];
        if(siz[el.ff]>bigv){
            bigv=siz[el.ff];
            bigc=el.ff;
            bige=el.ss;
;        }
 
    }
    bigchild[s][0]=bigc;
    bigchild[s][1]=bige;
}
int LCA(int u,int v){
 
    if(dis[u]<dis[v]){
        int temp=dis[v]-dis[u];
        for(int i=0;i<L;i++){
            if(temp &(1<<i))v=up[v][i];
        }
    }
    else if(dis[v]<dis[u]){
 
        int temp=dis[u]-dis[v];
        for(int i=0;i<L;i++){
            if(temp &(1<<i))u=up[u][i];
 
        }
    }
    if(u==v)return u;
    for(int i=L-1;i>=0;i--){
 
        if(up[u][i]!=up[v][i]){
            u=up[u][i];
            v=up[v][i];
        }
    }
    return up[u][0];
}
 
void chain_init(int n){
 
    fo1(i,n)chain[i]=i;
 
}
void dfs_chains(int s,int p){
 
        if(bigchild[s][0]!=-1){
            chain[bigchild[s][0]]=chain[s];
        }
        for(auto el:graph[s]){
 
            if(el.ff!=p){
 
                dfs_chains(el.ff,s);
            }
        }
 
 
}
void dfs_labels(int s,int p,int ed){
 
    tin[s]=++cnt;
    // cout<<s<<"lala"<<endl;
    tr.update(tin[s],arr[ed]);//segment tree or BIT whichever is better
    // cout<<s<<"lala2"<<endl;
   if(bigchild[s][0]!=-1) dfs_labels(bigchild[s][0],s,bigchild[s][1]);
    for(auto el:graph[s]){
            if(el.ff!=p && el.ff!=bigchild[s][0]){
                dfs_labels(el.ff,s,el.ss);
            }
    }
}
 
int get_anc(int u,int k){
 
    fo(i,18){
        if(k& 1<<i){
            u=up[u][i];
 
        }
    }
    return u;
}
int query_chains(int u,int p){
    //gets the sum till the value below the LCA
    int val=0;
    //need to modify the query
    while(chain[u]!=chain[p]){

        int node=chain[u];
        int node2=up[node][0];
        amax(val,tr.query(tin[node],tin[u]));
        u=chain[u];
        u=up[u][0];
    }
    if(p!=u){
        amax(val,tr.query(tin[p]+1,tin[u]));
    }
    return val;
 
}
 
int path_query(int u,int v){
 
    int lc=LCA(u,v);
    int val=max(query_chains(u,lc),query_chains(v,lc));
    // if(lc==u){

    // }
    // amax(val,tr.query(tin[lc],tin[lc]));//bit query;
    // val-=arr[lc];
    return val;
    
}
int path_update(int u,int v){
    //will need lazyprop for this
    return 0;
    
}

