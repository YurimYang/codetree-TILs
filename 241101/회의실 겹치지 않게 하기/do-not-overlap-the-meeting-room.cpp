#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
vector<pair<int,int> > meeting; // {s,e}

bool cmp(pair<int,int> &a, pair<int,int> &b){
    if(a.second==b.second) return a.first<b.first;
    return a.second<b.second;
}

int main() {
    cin >> n;
    meeting.resize(n);
    for(int i=0; i<n; ++i){
        cin >> meeting[i].first >> meeting[i].second;
    }

    sort(meeting.begin(), meeting.end(), cmp);

    //for(int i=0; i<n; ++i){
    //    cout << meeting[i].first << " " << meeting[i].second <<'\n';
    //}

    int answer=0, lastEndTime=meeting[0].second;
    for(int i=1; i<n; ++i){
        if(lastEndTime<=meeting[i].first){
            lastEndTime=meeting[i].second;
        }
        else answer++;
    }
    cout << answer << '\n';
    return 0;
}