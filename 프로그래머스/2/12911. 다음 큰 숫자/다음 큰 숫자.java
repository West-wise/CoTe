class Solution {
    public int solution(int x) {
        int smallest = x & -x;     // rightmost 1 bit
        int ripple   = x + smallest;
        int ones     = x ^ ripple;
        ones = (ones >> 2) / smallest;
        return ripple | ones;
    }
}