package alpha;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

public class Stats {

	double[] numbers = null;
	double sum = 0;
	int length = 0;

	public Stats(double[] numbers) {
		this.numbers = numbers;
		length = numbers.length;
		for (double d : numbers) {
			sum += d;
		}
	}

	public double Mean() {
		return sum / length;
	}

	public double Mode() {
		double maxValue = 0;
		double maxCount = 0;

		for (int i = 0; i < length; i++) {
			int count = 0;
			for (int j = 0; j < length; j++) {
				if (numbers[j] == numbers[i]) {
					++count;
				}
			}
			if (count > maxCount) {
				maxCount = count;
				maxValue = numbers[i];
			}
		}
		if(maxCount==1) {
			return 0;
		} else {
			return maxValue;
		}
		
	}

	public double Median() {
		double [] temp = numbers.clone();
		Arrays.sort(temp);
		if (length % 2 == 0) {
			return ((temp[(length / 2)] + temp[(length / 2) - 1]) / 2);
		} else {
			return temp[length / 2];
		}
	}

	public double Variance() {
		double sumOfDifferenceSquared = 0;
		for (double d : numbers) {
			sumOfDifferenceSquared += Math.pow(d - Mean(), 2);
		}
		return sumOfDifferenceSquared/(length-1);
	}
	
	public double StandardDeviationSample() {
		return Math.sqrt(Variance());
	}

	public double StandardDeviationPopulation() {
		double sumOfDifferenceSquared = 0;
		for (double d : numbers) {
			sumOfDifferenceSquared += Math.pow(d - Mean(), 2);
		}
		return Math.sqrt(sumOfDifferenceSquared/(length));
	}
	
	public double range() {
		double [] temp = numbers.clone();
		Arrays.sort(temp);
		return (temp[length-1]-temp[0]);
	}

	public String toString() {
		System.out.print("Unsorted: ");
		for(int i=0; i<length; i++) {
			if(i<length-1) {
				System.out.print(numbers[i] + ", ");
			} else {
				System.out.print(numbers[i] + "\n");
			}
		}
	
		System.out.print("\nSorted: ");
		double [] temp = numbers.clone();
		Arrays.sort(temp);
		for(int i=0; i<length; i++) {
			if(i<length-1) {
				System.out.print(temp[i] + ", ");
			} else {
				System.out.print(temp[i] + "\n");
			}
		}
		
		
		NumberFormat nf = NumberFormat.getInstance();
		String output = String.format(
				"\nMean: \t\t\t%s\n" + "Mode: \t\t\t%s\n" + 
				"Median: \t\t%s\n" + 
				"Variance: \t\t%s\n" +
				"Standard Deviation: \t%s\n" +
				"Range: \t\t\t%s\n",
				nf.format(Mean()),
				nf.format(Mode()), 
				nf.format(Median()),
				nf.format(Variance()), 
				nf.format(StandardDeviationSample()), 
				nf.format(range())
				);
		return output;
	}

}
