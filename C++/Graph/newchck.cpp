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
vector<pair<int,int>>bridges;
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
            if(low[el]>tin[s]){
                bridges.pb(mp(min(el,s),max(el,s)));
            }
            if(par!=-1 && low[el]>=tin[s])AP.pb(s);
            child++;
        }
    }
    if(par==-1 & child>1)AP.pb(s);
}



void find_bridges(int n){
    timer=0;
    for(int i=1;i<=n;i++)vis[i]=false;
    timer=0;
    for(int i=1;i<=n;i++){

        if(!vis[i]){
            dfs(i,-1);
        }
    }
    sort(AP.begin(),AP.end());
    sort(bridges.begin(),bridges.end());
    cout<<AP.size()<<"\n";
    for(auto el:AP)cout<<el<<" ";
    cout<<"\n";
    cout<<bridges.size()<<"\n";
    for(auto el:bridges){

        cout<<el.ff<<" "<<el.ss<<"\n";
    }
    //cout<<"\n";

    



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
    find_bridges(n);



}