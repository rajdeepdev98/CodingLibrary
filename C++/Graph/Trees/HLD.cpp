 
// HLD implementation for max along a path in a tree
void dfs_size(int s,int p){
 
    dis[s]=dis[p]+1;
    // tin[s]=++cnt;
    up[s][0]=p;
    
     for(int i=1;i<21;i++){
 
        up[s][i]=up[up[s][i-1]][i-1];//binary lifting
 
    }
    siz[s]=1;
    int bigv=-1,bigc=-1;
    for(auto el:graph[s]){
 
        if(el==p)continue;
        dfs_size(el,s);
        siz[s]+=siz[el];
        if(siz[el]>bigv){
            bigv=siz[el];
            bigc=el;
        }
 
    }
    bigchild[s]=bigc;
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
 
        if(bigchild[s]!=-1){
            chain[bigchild[s]]=chain[s];
        }
        for(auto el:graph[s]){
 
            if(el!=p){
 
                dfs_chains(el,s);
            }
        }
 
 
}
void dfs_labels(int s,int p){
 
    tin[s]=++cnt;
    tr.update(barr,tin[s],arr[s]);//segment tree or BIT whichever is better
   if(bigchild[s]!=-1) dfs_labels(bigchild[s],s);
    for(auto el:graph[s]){
            if(el!=p && el!=bigchild[s]){
                dfs_labels(el,s);
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
    while(chain[u]!=chain[p]){

        amax(val,tr.query(tin[chain[u]],tin[u]));
        u=chain[u];
        u=up[u][0];
    }
    amax(val,tr.query(tin[p],tin[u]));
    return val;
 
}
 
int path_query(int u,int v){
 
    int lc=LCA(u,v);
    int val=max(query_chains(u,lc),query_chains(v,lc));
    // amax(val,tr.query(tin[lc],tin[lc]));//bit query;
    return val;
    
}
int path_update(int u,int v){
    //will need lazyprop for this
    return 0;
    
}