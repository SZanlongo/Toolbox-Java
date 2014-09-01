package arrays;

import java.util.Random;

public class QuickListClient {

	public static void main(String[] args) {
		QuickList friends = new QuickList("My friends");
		System.out.println(friends);
		System.out.println();

		int nbrOfFriends = 5 + ((new Random())).nextInt(11);

		for (int k = 1; k <= nbrOfFriends; k++) {
			friends.add(getRandomName());
		}
		System.out.println(friends);
		System.out.println();

		String name = getRandomName();
		if (!friends.has(name)) {
			System.out.println(name + " is not on my friends list");
		} else {
			friends.delete(name);
			System.out.println(name + " was removed from my friends list");
			System.out.println();
			System.out.println(friends);
		}
	}

	private static String getRandomName() {
		String[] names = { "Anne", "Adam", "Alejandro", "Basil", "Betty", "Bill", "Claire",
				"Carlos", "Connie", "Danny", "David", "Dianne", "Eugene", "Francisco", "Halle",
				"Harry", "Hazel", "Ian", "Jaime", "Jorge", "Jennifer", "Kaye", "Margaret", "Manny",
				"Maria", "Nicole", "Olga", "Oliver", "Peter", "Raul", "Randolph", "Steve",
				"Sandra", "Tammy", "Uwe", "Xavier", "Ziggy" };

		return names[(new Random()).nextInt(names.length)];
	}
}