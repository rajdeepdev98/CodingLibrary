#include<bits/stdc++.h>
#define pb push_back

using namespace std;
const int MX=(int)(1e5)+5;
vector<int>graph[MX];
vector<int>diam;
int node=-1;
int mx=-1;


void dfs(int s,int par,int depth){
    int temp=,x;
    if(depth>mx){
        mx=depth;
        node=s;
    }
    
   for(auto el:graph[s]){

        if(el!=par){

            dfs(el,s,depth+1);
        }
    }
    



}
bool dfs2(int s,int par){


    if(s==node)return true;
    for(auto el:graph[s]){

        if(el!=par){
            bool res=dfs(el,s);
            if(res){
                diam.pb(el);
                return true;
            }
        }
    }

    
}

void diameter(int n){
    //find the farthest node from any node
    dfs(1,-1,0,0);
    //now node contains one of the endpoints of the diameter
    mx=-1;
    int tempnode=node;


    dfs(tempnode,-1,0,0);
    bool res=dfs2(tempnode,-1);
    diam.pb(tempnode);
    //The diameter is stored from node to tempnode
    //The reverse can also be done
    //Either by using the reverse function in stl
    //or by changing the dfs2 function
    reverse(diam.begin(),diam.end());
    for(auto el:diam)



}



int main(){

    int n;
    cin>>n;
    int a,b;
    for(int i=1;i<=n-1;i++){

        cin>>a>>b;
        graph[a].pb(b);
        graph[b].pb(a);
    }
    diameter(n);//function to find the diameter of the tree


    return 0;



}

