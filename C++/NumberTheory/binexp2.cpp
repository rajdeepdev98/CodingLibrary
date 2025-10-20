#include<bits/stdc++.h>
#define lli long long int
using namespace std;

template<typename T,typename Tp>
lli binexp(T no,Tp pw){

    lli res=1;
    lli pw2=pw;
    lli val=no;
    lli temp=1;
    while(pw2>0){

        if(temp& pw2){
            res*=val;
            pw2^=temp;
        }
        val*=val;
        temp<<=1;
        

        
    }
    return res;

}
int main(){

    cout<<binexp(2,4)<<"\n";
    return 0;
}
