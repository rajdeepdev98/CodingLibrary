#include<bits/stdc++.h>

using namespace std;

const int N=(int)(1e5)+5;

int SA[N];

void createsuff(string s){

    s+='$';
    int n=s.length();
    const int alphabet=256;
    vector<int>per(n),cl(n),cnt(max(alphabet,n),0);
    //I'll use it as a black box
    for(int i=0;i<n;i++){

        cnt[s[i]]++;//I will typecast it later if required

    }
   
   for(int i=1;i<alphabet;i++){

        cnt[i]+=cnt[i-1];
    }

    for(int i=0;i<n;i++){

        per[--cnt[s[i]]]=i;//counting sort
    }
  
    int rnk=0;
    cl[per[0]]=0;
    for(int i=1;i<n;i++){

        if(s[per[i]]!=s[per[i-1]])rnk++;
        cl[per[i]]=rnk;


    }
    //now the 2nd part

    vector<int>p2(n),cl2(n);
    for(int h=0;(1<<h)<n;++h){


        for(int i=0;i<n;i++){

            p2[i]=per[i]-(1<<h);
            if(p2[i]<0)p2[i]+=n;
        }
    
    fill(cnt.begin(),cnt.begin()+rnk+1,0);
    for(int i=0;i<n;i++){

        cnt[cl[p2[i]]]++;
    }
    for(int i=1;i<n;i++){
        cnt[i]+=cnt[i-1];


    }
    for(int i=n-1;i>=0;i--){

        per[--cnt[cl[p2[i]]]]=p2[i];

    }
    cl2[per[0]]=0;
    rnk=0;
    for(int i=1;i<n;i++){

        pair<int,int>cur={cl[per[i]],cl[(per[i]+(1<<h))%n]};
        pair<int,int>prev={cl[per[i-1]],cl[(per[i-1]+(1<<h))%n]};
        
        if(cur!=prev)rnk++;
        cl2[per[i]]=rnk;

    }
    cl.swap(cl2);
    
    
    }
   for(int i=0;i<n;i++)SA[i]=per[i];
   
}

int main(){


    string s;
    cin>>s;
    createsuff(s);
    for(int i=0;i<s.length();i++)cout<<SA[i]<<" ";
    //Something is seriously wrong in this code


    return 0;
}