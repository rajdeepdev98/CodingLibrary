/**
 *    author:  MrRD
 *    created: 2022-12-06 17:50:43  
 *    Added the prefix function calculation algorithm
 *    pref[i]=length of longest length of proper prefix which is also a suffix of the string s[0...i]    
**/
vector<int> prefix_function(string s) {
    int n = (int)s.length();
    vector<int> pi(n);
    for (int i = 1; i < n; i++) {
        int j = pi[i-1];
        while (j > 0 && s[i] != s[j])
            j = pi[j-1];
        if (s[i] == s[j])
            j++;
        pi[i] = j;
    }
    return pi;
}





