/*
������ ���� ���ϱ�
*/
#include <iostream>
using namespace std;
int reverse(int x)
{
	int answer = 0;
	while (x != 0) {//x > 0���� ������ �ָ� ������ ����X
		answer = (answer * 10) + x % 10;
		x /= 10;
	}
	return answer;
}

int main()
{
	int x;
	cin >> x;
	cout << reverse(x) << endl;
	return 0;
}