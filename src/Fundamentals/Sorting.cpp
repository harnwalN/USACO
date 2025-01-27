#include <bits/stdc++.h>
using namespace std;

struct Number {
    int value;
    int secondary_value;

    Number(int val, int second_val) {
        value = val;
        secondary_value = second_val;
    }
};
bool cmp (Number a, Number b) {
    // Custom comparator for custom Number class that sorts in ascending order based on "value"
    return a.value < b.value;
}
bool cmp2 (Number a, Number b) {   
    // Custom comparator for custom Number class that sorts in ascending order based on "secondary_value"
    return a.secondary_value < b.secondary_value;
}
bool operator<(const Number &a, const Number &b) {
    return a.secondary_value < b.secondary_value;
}

vector<int> v {1, 3, 2, 4, 5, 7, 6, 8};
int arr[8] {1, 3, 2, 4, 5, 7, 6, 8};
vector<Number> v_num = {Number(1, 8), Number(2, 7), Number(3, 6), Number(4, 5), Number(5, 4), Number(6, 3), Number(7, 2), Number(8, 1)};
priority_queue<Number> pq;

int n = 8;

void reset() {
    v = {1, 3, 2, 4, 5, 7, 6, 8};
    copy(v.begin(), v.end(), arr);
    v_num = {Number(1, 8), Number(2, 7), Number(3, 6), Number(4, 5), Number(5, 4), Number(6, 3), Number(7, 2), Number(8, 1)};

    while (!pq.empty()) {pq.pop();}
    for (int i = 1; i<=8; i++) {
        pq.push(Number(i, 9-i));
    }
}

void print() {
    cout << "Vector: ";
    for (int el : v) cout << el;
    cout << "\nArray: ";
    for (int el : arr) cout << el;
    cout << "\n" << endl;
}

void print_pq() {
    while (!pq.empty()) {
        cout << "(" << pq.top().value << ", " << pq.top().secondary_value << ") ";
        pq.pop();
    }
    cout << endl;
}

int main() {
    // Initial values
    cout << "Initial Values" << "\n";
    print();

    // Sorting regularly (ascending)
    cout << "Sorted ascending" << "\n";
    sort(v.begin(), v.end());
    sort(arr, arr+8);

    print();
    reset();

    // Sorted descending
    cout << "Sorted descending" << "\n";
    sort(v.begin(), v.end(), greater<int>());
    sort(arr, arr+8, greater<int>());
    
    print();
    reset();

    // Sorted Numbers using custom comparator "cmp"
    cout << "Sorting custom class using a custom comparator cmp" << "\n";
    sort(v_num.begin(), v_num.end(), cmp);
    for (Number el : v_num) cout << "(" << el.value << ", " << el.secondary_value << ") ";
    cout << endl;

    reset();

    // Sorted Numbers using custom comparator "cmp"
    cout << "Sorting custom class using a custom comparator cmp2" << "\n";
    sort(v_num.begin(), v_num.end(), cmp2);
    for (Number el : v_num) cout << "(" << el.value << ", " << el.secondary_value << ") ";
    cout << endl;

    // Priority Queue Sorted based on overloaded "<" operator
    cout << "Sorted priority queue based on overloaded '<' operator" << "\n";
    print_pq();
    reset();
}