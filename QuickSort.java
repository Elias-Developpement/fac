public class QuickSort {
  public static void main(String args[]) {
    int[] table = {125, 365, 458, 654, 216, 975, 123};
    table = quicksort(table, 0, table.length - 1);

    for(int i = 0; i < table.length; i++) {
      System.out.print("" + table[i] + " ");
    }
  }

  private static int[] quicksort(int table[], int to_left, int to_right) {
  	int i, j;
  	int pivot, temporary;
  	i = to_left;
  	j = to_right;
  	pivot = table[(to_left + to_right) / 2];

  	do {
  		while ((table[i] < pivot) && (i < to_right)) {
  		  i++;
  		}

  		while ((pivot < table[j]) && (j > to_left))	{
  		  j--;
  		}

  		if (i <= j) {
    		temporary = table[i];
    		table[i] = table[j];
    		table[j] = temporary;
    		i++;
    		j--;
  		}
  	} while (i <= j);

  	if (to_left < j) {
  	  table = quicksort(table, to_left, j);
  	}

  	if (i < to_right) {
  		table = quicksort(table, i, to_right);
  	}

    return table;
  }
}
