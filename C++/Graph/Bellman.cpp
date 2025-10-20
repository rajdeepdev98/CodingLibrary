struct edge{

    int a,b,cost ;
    void edge(int x,int y, int w){
        a=x;
        b=y;
        cost=w;
    }
    

};

vector<edge>edges;

void addedge(int m){

    int a,b,w;
    fo1(i,m){

        cin>>a>>b>>w;
        edge temp(a,b,w);
        edges.pb(temp);
    }
}

void bford(int n,int m,int v){

    vector<int>dis(n+1,INF);
    vector<int>pred(n+1,-1);
    dis[v]=0;
    fo(i,n-1){

        fo(j,m){

            if(dis[edges[j].a]<INF){
                if(dis[edges[j].b]>dis[edges[j].a]+edges[j].cost){

                    dis[edges[j].b]=dis[edges[j].a]+edges[j].cost;
                    pred[edges[j].b]=edges[j].a;
                }
            }
        }




    }
    //retrieving path
    if(dis[t]==INF){

        cout<<"Theres no path from node "<<v<<"to node "<<t<<"\n";
        return; 
    }
    else{

        vector<int>path;
        for(int cur=t;cur!=-1;cur=pred[cur]){

            path.pb(curr);
        }
        reverse(all(path));
        for(auto el:path)cout<<el<<" ";
        cout<<"\n";
    }


    
    //this is enough to find the distance from a particular vertex if no negative cycles are there
    //If there is a negative cycle,the nth iteration will also produce some relaxation!1
    //check if theres anegative cycle!!
    int chck=-1;
    fo(i,m){

        if(dis[edges[j].a]<INF){
                if(dis[edges[j].b]>dis[edges[j].a]+edges[j].cost){

                    dis[edges[j].b]=dis[edges[j].a]+edges[j].cost;
                    pred[edges[j].b]=edges[j].a;
                    chck=edges[j].b;
                }
            }

    }
    if(chck==-1){

        cout<<"Theres no negative cycle in this graph!\n";
        return ;
    }
    else{

        int y=chck;

        fo1(i,n){

            y=pred[y];

        }
        vector<int>negcycle;
        for(int cur=y;;cur=pred[cur]){

            if(cur==y && negcycle.size()>0)break;
            negcycle.pb(cur);
        }
        //The vector negcycle contains th e required negative cycle
    }

}

