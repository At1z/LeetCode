class Solution {
public:
    vector<string> fizzBuzz(int n) {
       std::vector<string> v;
        for(int i = 1; i <= n; i++){
            if(i % 15 == 0){
                v.push_back("FizzBuzz");
            }else if(i % 3 == 0){
                v.push_back("Fizz");
            }else if(i % 5 == 0){
                v.push_back("Buzz");
            }else{
                v.push_back(std::to_string(i));
            }
        }
       return v;
    }
};