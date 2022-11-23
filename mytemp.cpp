/**
 *    author:  MrRD
 *    created: $CURRENT_YEAR-$CURRENT_MONTH-$CURRENT_DATE $CURRENT_HOUR:$CURRENT_MINUTE:$CURRENT_SECOND      
**/
#include<bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp> // Common file
#include <ext/pb_ds/tree_policy.hpp> // Including tree_order_statistics_node_update
#define lli long long int
#define pb push_back
#define in insert
#define mp make_pair
#define pii pair<int,int>
#define piil pair<lli,lli>
#define ff first
#define ss second
#define sz(x) (int)(x.size())
#define all(x) x.begin(),x.end()
#define clr(x) memset(x,0,sizeof(x))
#define fo(i,n) for(int i=0;i<n;i++)
#define fo1(i,n) for(int i=1;i<=n;i++)
#define FOR(i,a,b) for(int i=a;i<=b;i++)
#define FORN(i,a,b) for(int i=a;i>=b;i--)
#define b_pop(x)  __builtin_popcount(x)
#define b_popll(x) __builtin_popcountll(x)
#define b_clz(x) __builtin_clz(x)
#define fast ios_base::sync_with_stdio(0);cin.tie(0);cout.tie()
#define trav(a,x) for (auto& a: x)
#define deb(x) cout<<#x<<"="<<x<<"\n"//debugging
#define OJ \
    freopen("input.txt", "r", stdin); \
    freopen("output.txt", "w", stdout);

using namespace __gnu_pbds;
using namespace std;

typedef tree<
int,
null_type,
less<int>,
rb_tree_tag,
tree_order_statistics_node_update>
ordered_set;
const int MX=(int)(2e5)+5;
int darr[4][2]={{1,0},{-1,0},{0,1},{0,-1}};
int arr[MX];
vector<int>graph[MX];

// Utility functions
void setPrec() { cout << fixed << setprecision(15); }
template<typename A>
A Max(A a,A b){
    return max(a,b);
}
template<typename A,typename... Args>
A Max(A a,A b,Args... args){
    return Max(Max(a,b),args...);
}
template<typename A>
A Min(A a,A b){
    return min(a,b);
}
template<typename A,typename... Args>
A Min(A a,A b,Args... args){
    return Min(Min(a,b),args...);
}
template<typename A,typename... Args>
void amin(A& a,Args... args){
    a=Min(a,args...);
}
template<typename A,typename... Args>
void amax(A& a,Args... args){
    a=Max(a,args...);
}
void dbg_out() { cout << endl; }
template<typename Head, typename... Tail> void dbg_out(Head H, Tail... T) { cout << H<<" "; dbg_out(T...); }

//GCD portion (without Euclids)

template<typename T>

T GCD(T a,T b){
    if(b==0)return a;
    else return GCD(b,a%b);
}


//adding a graph template
void ipgraph(int n,int m){

    int u,v;
    fo1(i,m){
        cin>>u>>v;
        graph[u].pb(v);
        graph[v].pb(u);
    }
}





//problem solver
void solve(){
    
   
}


int main(){ 
   
    // OJ;

    fast;

    int t;
    cin>>t;
    // t=1;

    while(t--){
        solve();

    }
    
    return 0;
}



