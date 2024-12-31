#include <bits/stdc++.h>

using namespace std;

int main() {
    int t;
    cin >> t;
    // if it's your turn and you always keep it a multiple of 4 after your turn, you will win
    // if it's not possible to keep it a multiple of 4 after your turn
    // (aka the number you start with is not a multiple of 4) then you lose

    // if you know you will lose (multiple of 4) decrease by 2s
    // because it should be <4, and any other number <=4 allows other to skip a multiple of 4
    // if you know you'll win, try to get to the lowest multiple of 4 you can on the first move
    int primes[5000000] {};
    for (int i = 2; i<=2237; i++) {
        if (primes[i]==1) {continue;}
        else {
            for (int j = i+i; j<5000000; j+=i) {
                primes[j]=1;
            }
        }
    }

    for (int test = 0; test < t; test++) {
        int rooms;
        cin >> rooms;

        vector<int> values;
        for (int i = 0; i<rooms; i++) {
            int v;
            cin >> v;
            values.push_back(v);
        }

        string winner;
        int fastest = 9999999;

        for (int i = 0; i<rooms; i++) {
            int v = values[i];
            int most = 0;
            for (int r = values[i]%4; r<=values[i]; r+=4) {
                if (primes[r]==0) {
                    most = max(most, r);
                }
            }

            int rounds; // round that the farmer loses on
            string wins;
            if (values[i]%4==0) { // iterate through primes instead
                rounds = (values[i]/4)+1;
                wins = "Farmer Nhoj";
            } else {
                rounds = ((values[i]-most)/4)+1;
                wins = "Farmer John";
            }
            if (rounds < fastest) {
                fastest = rounds;
                winner = wins;
            }
        }
        cout << winner << "\n";

    }
}