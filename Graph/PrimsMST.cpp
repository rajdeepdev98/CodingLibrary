#include<bits/stdc++.h>
#define mp make_pair
#define in insert
#define er erase
#define ff first
#define ss second
#define pb push_back
using namespace std;

 // adjacency matrix of graph
const int INF = 1000000000; // weight INF means there is no edge

struct Edge {
    int w = INF, to = -1;
    bool operator<(Edge const& other) const {
        return make_pair(w, to) < make_pair(other.w, other.to);
    }//this is defining the < operator for the Edge datatype
};
/*
void primdense() {
    int total_weight = 0;
    vector<bool> selected(n, false);
    vector<Edge> min_e(n);
    min_e[0].w = 0;

    for (int i=0; i<n; ++i) {
        int v = -1;
        for (int j = 0; j < n; ++j) {
            if (!selected[j] && (v == -1 || min_e[j].w < min_e[v].w))
                v = j;
        }

        if (min_e[v].w == INF) {
            cout << "No MST!" << endl;
            exit(0);
        }

        selected[v] = true;
        total_weight += min_e[v].w;
        if (min_e[v].to != -1)
            cout << v << " " << min_e[v].to << endl;

        for (int to = 0; to < n; ++to) {
            if (adj[v][to] < min_e[to].w)
                min_e[to] = {adj[v][to], v};
        }
    }

    cout << total_weight << endl;
}*/
vector<pair<int,int>>adj[10005];
void Primsparse(int n){
    vector<bool>vis(n+1,false);
    
    
    set<pair<int,int>>st;
    st.in(mp(0,1));
    int weight=0;
    while(!st.empty()){

        auto it=st.begin();
        int wg=it->ff;
        int to=it->ss;
        st.erase(it);
        if(vis[to])continue;
        vis[to]=true;
        weight+=wg;
        for(auto el:adj[to]){
            if(!vis[el.ff]){
                st.in(mp(el.ss,el.ff));
            }
        }
    }
    bool possbl=true;
    for(int i=1;i<=n;i++){

        if(!vis[i]){
            possbl=false;
            break;
        }
    }
    if(!possbl){

        cout<<"NO MST\n";
        exit(0);
    }
    cout<<weight<<"\n";




}

int main(){

    int n,m;
    cin>>n>>m;
    int a,b,w;
    for(int i=1;i<=m;i++){
        cin>>a>>b>>w;
        adj[a].pb(mp(b,w));
        adj[b].pb(mp(a,w));



    }
    Primsparse(n);
    //ALways remember that spanning tree is only for undirected graph


    return 0;


}