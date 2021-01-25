/**
 * Author: Rajdeep Deb
 * Date: 25-01-2021
 * Reference:Ecnerwala ICPC Book
 * Description: Basic operations on square matrices.
 * Usage: Matrix<lli> A(3);
 *  A.d = {{{{1,2,3}}, {{4,5,6}}, {{7,8,9}}}};
 *  vector<int> vec = {1,2,3};
 *  vec = (A^N) * vec;
 * modno=1e9+7(generally)
 * Status: tested by MrRD(Rajdeep)
 */
// #pragma once

template<class T> struct Matrix {
	typedef Matrix M;

    vector<vector<T>>a;
    int N;
    Matrix(int n){

        N=n;
        a.resize(n,vector<T>(n));
    }

    
	M operator*(const M& m) const {
		M a(N);
		fo(i,N)fo(j,N)fo(k,N){

            a.d[i][k]=(a.d[i][k]+(d[i][j]*(m.d[j][k]))%modno)%modno;
        }
		return a;
	}
	vector<T> operator*(const vector<T>& vec) const {
		vector<T> ret(N);
		fo(i,N)fo(j,N)ret[i]=(ret[i]+(d[i][j] * vec[j])%modno)%modno;
		return ret;
	}
	M operator^(lli p) const {
		assert(p >= 0);
		M a(N), b(*this);
		fo(i,N) a.d[i][i] = 1;
		while (p) {
			if (p&1) a = a*b;
			b = b*b;
			p >>= 1;
		}
		return a;
	}
};