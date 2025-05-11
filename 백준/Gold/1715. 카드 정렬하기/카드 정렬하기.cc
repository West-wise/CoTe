#include <iostream>
#include <queue>
#include <vector>

class MinCostCombiner {
private:
    int N;
    std::priority_queue<int, std::vector<int>, std::greater<int>> pq;

public:
    void readInput() {
        std::cin >> N;
        if (std::cin.fail() || N <= 0) {
            std::cerr << "Invalid input" << std::endl;
            N = 0;
            return;
        }

        for (int i = 0; i < N; ++i) {
            int num;
            std::cin >> num;
            if (std::cin.fail()) {
                std::cerr << "Invalid number input" << std::endl;
                continue;  // Skip invalid inputs
            }
            pq.push(num);
        }
    }

    int computeMinCost() {
        if (pq.size() <= 1) return 0;

        int result = 0;
        while (pq.size() > 1) {
            int first = pq.top(); pq.pop();
            int second = pq.top(); pq.pop();

            int merged = first + second;
            result += merged;

            pq.push(merged);
        }

        return result;
    }

    void run() {
        readInput();
        int result = computeMinCost();
        std::cout << result << std::endl;
    }
};

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);

    MinCostCombiner combiner;
    combiner.run();

    return 0;
}
