#define vi vector<int>
#define vil vector<lli>
#define lli long long int
#define all(x) x.begin(),x.end();
typedef pair<lli,int>pli;
const int L=15;


struct suffarr
{
       string s1;int n;
       vi SA,LCP,RA;
       vector<vi>ST; 
       void init(string s){

            n=s.length()+1;
            s1=s+'$';computeSA();computeLCP();

            precomputemin();

       }
       
       void countingSort(int k){        
                        // O(n)
            int maxi = max(300, n);                      // up to 255 ASCII chars
            vi c(maxi, 0);                               // clear frequency table
            for (int i = 0; i < n; ++i)                  // count the frequency
            ++c[i+k < n ? RA[i+k] : 0];                // of each integer rank
            for (int i = 0, sum = 0; i < maxi; ++i) {
            int t = c[i]; c[i] = sum; sum += t;
            }
            vi tempSA(n);
            for (int i = 0; i < n; ++i)                  // sort SA
            tempSA[c[SA[i]+k < n ? RA[SA[i]+k] : 0]++] = SA[i];
            swap(SA, tempSA);                            // update SA
        }
       void computeSA(){
           SA.resize(n);
           iota(all(SA),0);
           RA.resize(n);
           for(int i=0;i<n;i++)RA[i]=s1[i];//Initial rankings
           for(int k=1;k<n;k<<=1){
            //    this is actually radix sort
                countingSort(k);//sort by 2nd item
                countingSort(0);//stable sort by 1st item
                vi tempRA(n);
                int r=0;
                tempRA[SA[0]]=r;
                for (int i = 1; i < n; ++i)  {              // compare adj suffixes
                    tempRA[SA[i]] = // same pair => same rank r; otherwise, increase r
                    ((RA[SA[i]] == RA[SA[i-1]]) && (RA[SA[i]+k] == RA[SA[i-1]+k])) ?
                        r : ++r;
                }
                swap(RA,tempRA);//update RA
                if(RA[SA[n-1]]==n-1)break;//nice optimization


           }

       }
    //    Trying to keep it well indented(formatted)as well
       void computeLCP(){
           LCP.resize(n);
            int h=0;
            for(int i=0;i<n;i++){

                if(RA[i]==0)continue;
                if(RA[i]>0){

                    int k=SA[RA[i]-1];
                    while(s1[i+h]==s1[k+h])h++;
                    LCP[RA[i]]=h;
                    if(h>0)h--;


                }
        
            }
        //wanna give a zero value to the first pref
             LCP[0]=0;
       }
       void precomputemin(){

            ST.resize(n,vector<int>(L,0));
            for(int i=1;i<n;i++)ST[i][0]=LCP[i];
            for(int j=1;j<L;j++){

                for(int i=1;i+(1<<j)<=n;i++){

                    ST[i][j]=min(ST[i][j-1],ST[i+(1<<(j-1))][j-1]);
                }
            }
    
       }
            // Its more important in graphs for binary lifting
        int query(int l,int r){

            int ans=INT_MAX;
            int dis=r-l+1;
            //now the tricky part used in case of idempotent functions
            int lr=log2(dis);
            int ld=1<<lr;
            ans=min(ST[l][lr],ST[r-ld+1][lr]);
            return ans;

        }


};
