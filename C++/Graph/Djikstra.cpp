
template<typename T>
class graph{

    public:
        vector<pair<T,T>>adj[100005];
        vector<T>dist;
        vector<bool>mark;
        T nodes;
        void addedge(T a,T b,T wght){
            adj[a].pb(mp(b,wght));
            adj[b].pb(mp(a,wght));
        }
        void init(T n){
            nodes=n;

            for(lli i=1;i<=n;i++)adj[i].clear();
            dist.resize(n,(lli)(1e9)+5);
            mark.resize(n,false);

        }
        //Djikstra may be
        void Djikstra(T node);
      



};

template<typename T>
void graph<T>::Djikstra(T node){
    //lets write Djikstra's all by myself
    dist[node]=0;
    set<pair<T,T>>st;
    st.in(mp(0,node));
    while(!st.empty()){

        lli v=st.begin()->ss;
        // lli wght=(st.begin()->ss;
        st.erase(st.begin());
        for(auto el:adj[v]){

            T to=el.ff;
            T len=el.ss;
            if(dist[v]+len<dist[to]){

                st.erase(mp(dist[to],to));
                dist[to]=dist[v]+len;
                st.in(mp(dist[to],to));
            }


        }

    }



}
