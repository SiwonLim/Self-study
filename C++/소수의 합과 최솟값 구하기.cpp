/*
�Ҽ��� �հ� �ּڰ� ���ϱ�
*/
#include <iostream>
using namespace std;

bool isPrime(int num)
{
	bool b = true;
	for (int j = 2; j <= sqrt(num); j++)
	{
		if (num % j == 0)//�Ҽ��ƴ�
		{
			b = false;
			break;
		}
	}
	return b;
}

int main()
{
	int M, N, answer[2] = {0,0};
	cout << "���� �� : ";
	cin >> M >> N;

	for (int i = M; i <= N; i++){
		if (isPrime(i))
		{
			answer[0] += i;
			if (answer[1] == 0) answer[1] = i;
			cout << i << " ";
		}
	}

	if (answer[1] == 0)
		cout << -1 << endl;
	else
		cout << endl << "�� : " << answer[0] << endl << "�ּڰ� : " << answer[1] << endl;
	
	return 0;
}