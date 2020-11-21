#include<bits/stdc++.h>
#define pb push_back

using namespace std;

vector<int>graph[10005];
bool vis[10005];
bool recstack[10005];

bool dfs(int s,vector<int>&vec){
    vis[s]=true;
    recstack[s]=true;
    
    for(auto el:graph[s]){
        if(!vis[el] && !recstack[el]){
            bool check=dfs(el,vec);
            if(!check)return check;


        
        }
        else if(recstack[el]){

            return false;
        }

    }
    vec.pb(s);
    recstack[s]=false;
    return true;


    
}
void Toposort(int n){

    //for toposort(1st we need to make sure that there is no cycle in the graph)
    vector<int>vec;//vector to store the topological order

    for(int i=1;i<=n;i++){

        if(!vis[i]){

           bool check= dfs(i,vec);
           if(!check){

               cout<<"Topological order doesnt exist\n";
               return;
           }

        }
    }
    reverse(vec.begin(),vec.end());
    cout<<"The topological order is:\n";
    for(auto el:vec)cout<<el<<" ";
    cout<<"\n";


}

int main(){

    int n,m;
    cin>>n>>m;
    int a,b;
    for(int i=1;i<=m;i++){

        cin>>a>>b;
        graph[a].pb(b);
        
    }
    Toposort(n);
    //so this toposort cannot find the lexicographically smallest ordering

    return 0;
    


}