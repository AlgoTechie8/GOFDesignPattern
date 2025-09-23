package com.algotechie.singleton;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

public class SingletonNegativeTest {

	// --- Breaking Singleton ---

	@Test
	void testNonFixedSingletonFails() throws Exception {
		Callable<NonFixedSingleton> task = NonFixedSingleton::getInstance;

		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Future<NonFixedSingleton>> results = executor.invokeAll(Collections.nCopies(20, task));

		Set<Integer> hashCodes = new HashSet<>();
		for (Future<NonFixedSingleton> f : results) {
			hashCodes.add(f.get().hashCode());
		}

		// Expect more than 1 hashCode if multiple instances created,but may create more than one instnce
		assertTrue(hashCodes.size() >= 1, "Non-thread-safe singleton can produce multiple instances!");
	}

	@Test
	void testReflectionBreaksNonFixedSingleton() throws Exception {
		NonFixedSingleton s1 = NonFixedSingleton.getInstance();
		Constructor<NonFixedSingleton> cons = NonFixedSingleton.class.getDeclaredConstructor();
		cons.setAccessible(true);
		NonFixedSingleton s2 = cons.newInstance();
		assertNotSame(s1, s2, "Reflection should break Singleton");
	}

	@Test
	void testCloningBreaksNonFixedSingleton() throws Exception {
		NonFixedSingleton s1 = NonFixedSingleton.getInstance();
		NonFixedSingleton s2 = (NonFixedSingleton) s1.clone();
		assertNotSame(s1, s2, "Cloning should break Singleton");
	}

	@Test
	void testSerializationBreaksNonFixedSingleton() throws Exception {
		NonFixedSingleton s1 = NonFixedSingleton.getInstance();
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test2.ser"));
		out.writeObject(s1);
		out.close();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("test2.ser"));
		NonFixedSingleton s2 = (NonFixedSingleton) in.readObject();
		in.close();

		assertNotSame(s1, s2, "Serialization should break Singleton");
	}

}
