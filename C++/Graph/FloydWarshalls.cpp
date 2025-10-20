struct edge{

    int a,b,cost;
    void edge(int x,int y,int w){

        a=x;
        b=y;
        w=cost;
    }

}
vector<edge>edges;
void Floyd(){

    vector<vector<int>(n+1,INF)>vec(n+1);
    fo1(i,n)dis[i][i]=0;

    edge ed;
    fo1(i,m){
        cin>>ed.a>>ed.b>>ed.w;
        edges.pb(edge);



    }
    for(auto el:edges){

        dis[el.a][el.b]=el.cost;
    }
    fo1(i,n){

        fo1(j,n){

            fo1(k,n){

                dis[j][k]=min(dis[j][k],min(dis[j][i]+dis[i][k],INF));
            }
        }



    }
    //the dis vector now contains the distances of all the nodes from each other



}