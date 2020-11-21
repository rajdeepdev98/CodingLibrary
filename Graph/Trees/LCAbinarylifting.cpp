#include<bits/stdc++.h>
#define pb push_back


using namespace std;
const int MX=(int)(1e5)+5;
const int L=32;


vector<int>graph[MX];
int dis[MX];
int up[MX][L];//array to store 

void dfs(int s,int p){
    
    dis[s]=dis[p]+1;
    up[s][0]=p;
    
    for(int i=1;i<L;i++){

        up[s][i]=up[up[s][i-1]][i-1];//binary lifting

    }
    for(auto el:graph[s]){
        if(el!=par){

            dfs(el,s);
        }
    }




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


int main(){


    int n;
    cin>>n;
    int a,b;
    for(int i=1;i<=n-1;i++){
        cin>>a>>b;
        graph[a].pb(b);
        graph[b].pb(a);
        //The nodes are have been stored in the graph
    }




}


