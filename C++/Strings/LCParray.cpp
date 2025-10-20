#include<bits/stdc++.h>
#include "suffar.h"

using namespace std;

const int N=int(1e5)+5;
int SA[N],RA[N],LCP[N];


void createLCP(string s){
    int n=s.length();
    for(int i=1;i<=n;i++)RA[SA[i]]=i;
    //creating the rank array

    int h=0;
    for(int i=0;i<n;i++){

        if(RA[i]==1)continue;
        if(RA[i]>1){

            int k=SA[RA[i]-1];
            while(s[i+h]==s[k+h])h++;
            LCP[RA[i]]=h;
            if(h>0)h--;


        }
        
    }
    //wanna give a zero value to the first pref
    LCP[0]=0;




    
}

int main(){


        string s;
        cin>>s;
        createsuff(s);//suffix array builder
        createLCP(s);//Implemented here
        for(int i=1;i<s.length();i++)cout<<LCP[i]<<" ";
        cout<<"\n";




    return 0;
}