#include<bits/stdc++.h>
#define pb push_back
#define in insert
#define er erase
#define mp make_pair
#define ff first
#define ss second

using namespace std;
vector<int>graph[10005];
bool vis[10005];
int tin[10005];
int low[10005];
int timer=0;
vector<int>AP;

void dfs(int s,int par){

    vis[s]=true;
    tin[s]=low[s]=timer++;
    int child=0;
    for(auto el:graph[s]){

        if(el==par)continue;
        if(vis[el]){

            low[s]=min(low[s],low[el]);
        }
        if(!vis[el]){
            dfs(el,s);
            low[s]=min(low[s],low[el]);
            if(low[el]>=tin[s] && par!=-1){
                AP.pb(el);
            }
            child++;
        }
        else{
            low[s]=min(low[s],low[el]);


        }

    }
    if(par==-1 && child>1)AP.pb(s);
}



void find_APS(int n){
    timer=0;
    for(int i=1;i<=n;i++)vis[i]=false;
    timer=0;
    for(int i=1;i<=n;i++){

        if(!vis[i]){
            dfs(i,-1);
        }
    }
    cout<<AP.size()<<"\n";
    for(auto el:AP){

        cout<<el<<" ";
    }
    cout<<"\n";

    



}
int main(){

    int n,m;
    cin>>n>>m;
    int a,b;
    for(int i=1;i<=m;i++){
        cin>>a>>b;
        graph[a].pb(b);
        graph[b].pb(a);
        


    }
    find_APS(n);



}