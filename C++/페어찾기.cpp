/*
��ǲ array�� �Է������� �־��� sum�� ������ �ϴ� ������ ������ index�� ���
ex) array=[3,7,5,4,2,0], sum = 11
*/
#include <iostream>
#include <vector>
using namespace std;

int main()
{
	vector<int> array;
	int ans, size;
	bool isFind = false;
	while (1){
		int t;
		cin >> t;
		array.push_back(t);
		if (getc(stdin) == '\n')break;
	}
	cin >> ans;
	size = array.size();
	for (int i = 0; i < size - 1; i++)
	{
		int find = ans - array[i];
		for (int j = i + 1; j < size; j++){
			if (find == array[j]){
				isFind = true;
				(i < j) ? cout << i << "," << j << endl : cout << j << "," << i << endl;
				break;
			}
		}
	}
	if (!isFind) cout << "��� ����" << endl;
	return 0;
}