template <class T>
struct segTree
{

    int n;
    T val;
    vector<T> vec;
    function<T(T, T)> comb;
    segTree(int nt, T val, function<T(T, T)> func) : n(nt), val(val), comb(func)
    {
        //combinator function is used to define the use case(RANGE_SUM,RANGE_MIN,RANGE_MAX)
        //val initializes the array accordingly
        vec.resize(2 * n + 1, val);
        build();
    }
    void build()
    {

        for (int i = 1; i <= n; i++)
        {
            vec[i + n] = arr[i];
        }

        for (int i = n; i > 1; --i)
        {
            vec[i] = comb(vec[i << 1], vec[i << 1 | 1]);
        }
    }
    void update(int p, T value)
    { // set value at position p
        for (vec[p += n] = value; p > 1; p >>= 1)
        {
            vec[p >> 1] = comb(vec[p], vec[p ^ 1]);
        }
    }
    T query(int l, int r)
    { // sum on interval [l, r)
        T res = val;
        for (l += n, r += n; l < r; l >>= 1, r >>= 1)
        {
            if (l & 1)
                res = comb(res, vec[l++]);
            if (r & 1)
                res = comb(res, vec[--r]);
        }
        return res;
    }
};