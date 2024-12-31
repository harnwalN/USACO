#include <bits/stdc++.h>
using namespace std;

struct Point {
    pair<int, int> coord;
    long time;
};

float dist(Point g, Point a) {
    return sqrt(
        (
            (g.coord.first-a.coord.first) * (g.coord.first-a.coord.first)
        ) + (
            (g.coord.second-a.coord.second) * (g.coord.second-a.coord.second)
        )
    );
}

// figure out how to search the map for the closest point that ends before and after A
// if it can feasibly get between those three points (before, point, end) then it make all of the points
// and thus the alibi does not make them innocent

vector<Point> gardens;

int main() {
    long g, n;
    cin >> g >> n;
    for (int i = 0; i<g; i++) {
        int gx, gy, t;
        cin >> gx >> gy >> t;
        Point g;
        g.coord = make_pair(gx, gy);
        g.time = t;
        gardens.push_back(g);
    }

    int count = 0;
    for (int i = 0; i<n; i++) {
        Point a;
        int ax, ay, t;
        cin >> ax >> ay >> t;
        a.coord = make_pair(ax, ay);
        a.time = t;

        bool works = true;

        for (const auto& g : gardens) {
            if (dist(a, g)>abs(a.time-g.time)) {
                works = false;
                break;
                cout << 1 << "\n";
            } else {
                a = g;
            }
        }
        if (!works) {
            count +=1;
        }
    }
    cout << count << endl;
}