/*
�ҹ���->�빮��
�빮��->�ҹ���
*/
#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main()
{
	int lowerA = 'a', sub = 'a' - 'A';
	string str;
	getline(cin, str);

	for (int i = 0; i < str.length(); i++)
	{
		if (isalpha(str[i]))//���ڶ��
		{
			if (str[i] >= lowerA) str[i] -= sub;//�ҹ���
			else str[i] += sub;//�빮��
		}
	}
	cout << str << endl;
	return 0;
}