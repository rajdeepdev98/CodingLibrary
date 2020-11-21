#include<bits/stdc++.h>
#define pb push_back
#define in insert

using namespace std;
vector<int>graph[100005];


void Toposort(int n){
    vector<int>indegree(n+1,0);
    for(int i=1;i<=n;i++){
        for(auto el:graph[i]){
            indegree[el]++;
        }
    }
    set<int>st;
    vector<int>vec;
    for(int i=1;i<=n;i++){

        if(indegree[i]==0)st.in(i);
    }
    while(!st.empty()){

        auto it=st.begin();
        int node=*it;
        vec.pb(node);
        st.erase(it);
        for(auto el:graph[node]){
            indegree[el]--;
            if(indegree[el]==0)st.in(el);
        }
    }
    for(auto el:vec)cout<<el<<" ";
    cout<<"\n";
    




}

int main(){

    int n,m,a,b;
    cin>>n>>m;
    for(int i=1;i<=m;i++){

        cin>>a>>b;
        graph[a].pb(b);
    }
    Toposort(n);
}
