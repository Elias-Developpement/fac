public class QuickSort {
  public static void main(String args[]) {
    int[] table = {125, 365, 458, 654, 216, 975, 123};
    table = quicksort(table, 0, table.length - 1);

    for(int i = 0; i < table.length; i++) {
      System.out.print("" + table[i] + " ");
    }
  }

  private static int[] quicksort(int items[], int left, int right) {
  	int i, j;
  	int pivot, temp;
  	i = left;
  	j = right;
  	pivot = items[(left + right) / 2];

  	do {
  		while ((items[i] < pivot) && (i < right)) {
  		  i++;
  		}

  		while ((pivot < items[j]) && (j > left))	{
  		  j--;
  		}

  		if (i <= j) {
    		temp = items[i];
    		items[i] = items[j];
    		items[j] = temp;
    		i++;
    		j--;
  		}
  	} while (i <= j);

  	if (left < j) {
  	  items = quicksort(items, left, j);
  	}

  	if (i < right) {
  		items = quicksort(items, i, right);
  	}

    return items;
  }
}
