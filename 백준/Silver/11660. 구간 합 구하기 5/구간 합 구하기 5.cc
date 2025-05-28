#include <iostream>
#include <sstream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n,m;
    cin>>n>>m;
    cin.ignore();
    int arr[n+1][n+1];

    for (int i = 1; i<=n; i++) {
        string line;
        getline(cin, line);
        istringstream iss(line);
        int num;
        for (int k = 1; k<=n; k++) {
            iss >> num;
            arr[i][k] = num + arr[i][k-1] + arr[i-1][k] - arr[i-1][k-1];
        }
    }
    for (int i = 0; i<m; i++) {
        string line;
        getline(cin,line);
        istringstream iss(line);
        int x1,y1,x2,y2;
        iss >> x1 >> y1 >> x2 >> y2;
        cout<<arr[x2][y2] - arr[x1-1][y2] - arr[x2][y1-1] + arr[x1-1][y1-1]<<'\n';
    }
    return 0;
}