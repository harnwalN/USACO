#include <bits/stdc++.h>

using namespace std;

vector<int> h;

int ans = 0;
int n;

// using a monotonic stack
void calc2() {
	stack<int> stk;
	for (int i = 0; i < n; i++) {
		while (!stk.empty() && h[stk.top()] < h[i]) stk.pop();
		if (!stk.empty()) ans += i-stk.top()+1;
		stk.push(i);
	}
}

void calc() {
    stack<int> stk;
    for (int i = 0; i<n; i++) {
        while (!stk.empty() && h[stk.top()]<h[i]) {
            stk.pop();
        }
        if (!stk.empty()) {
            ans += (i - stk.top()) + 1;
        }
        stk.push(i);
    }
}

int main() {
    cin >> n;
    for (int i = 0; i<n; i++) {
        int l;
        cin >> l;
        h.push_back(l);
    }

    ans = 0;

    calc2();

    reverse(begin(h), end(h));

    calc2();
    cout << ans << endl;
}