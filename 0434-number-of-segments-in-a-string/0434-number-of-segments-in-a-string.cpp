class Solution {
public:
    int countSegments(const std::string& s) {
        std::vector<std::string> segments = split(s, ' ');
        int count = 0;

        for (const auto& segment : segments) {
            if (!segment.empty()) {
                count++;
            }
        }

        return count;
    }

private:
    std::vector<std::string> split(const std::string& str, char delimiter) {
        std::vector<std::string> result;
        std::stringstream ss(str);
        std::string token;

        while (std::getline(ss, token, delimiter)) {
            result.push_back(token);
        }

        return result;
    }
};

