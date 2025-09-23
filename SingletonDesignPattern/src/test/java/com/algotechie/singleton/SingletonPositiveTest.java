package com.algotechie.singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

public class SingletonPositiveTest {
	// --- Fixed Singleton Tests ---
	
	@Test
    void testFixedSingletonIsThreadSafe() throws Exception {
        Callable<FixedMultiThreadingSingleton> task = FixedMultiThreadingSingleton::getInstance;

        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<FixedMultiThreadingSingleton>> results = executor.invokeAll(Collections.nCopies(20, task));
        executor.shutdown();

        Set<Integer> hashCodes = new HashSet<>();
        for (Future<FixedMultiThreadingSingleton> f : results) {
            hashCodes.add(f.get().hashCode());
        }

        // Only 1 instance expected
        assertEquals(1, hashCodes.size(), "FixedMultiThreadingSingleton must always return the same instance");
    }

    @Test
    void testEnumSingletonIsThreadSafe() throws Exception {
        Callable<EnumSingleton> task = () -> EnumSingleton.INSTANCE;

        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<EnumSingleton>> results = executor.invokeAll(Collections.nCopies(20, task));
        executor.shutdown();

        Set<Integer> hashCodes = new HashSet<>();
        for (Future<EnumSingleton> f : results) {
            hashCodes.add(f.get().hashCode());
        }

        assertEquals(1, hashCodes.size(), "EnumSingleton must always return the same instance");
    }
	
	@Test
	void testReflectionFailsOnFixedReflectionSingleton() throws Exception {
		FixedReflectionSingleton s1 = FixedReflectionSingleton.getInstance();

		Constructor<FixedReflectionSingleton> constructor = FixedReflectionSingleton.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		Exception exception = assertThrows(Exception.class, constructor::newInstance);
		assertTrue(exception.getCause() instanceof RuntimeException);
	}

	@Test
	void testCloningFailsOnFixedCloneableSingleton() {
		FixedCloneableSingleton s1 = FixedCloneableSingleton.getInstance();
		assertThrows(CloneNotSupportedException.class, s1::clone);
	}

	@Test
	void testSerializationSafeOnFixedSerializableSingleton() throws Exception {
		FixedSerializableSingleton s1 = FixedSerializableSingleton.getInstance();
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.ser"));
		out.writeObject(s1);
		out.close();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.ser"));
		FixedSerializableSingleton s2 = (FixedSerializableSingleton) in.readObject();
		in.close();

		assertSame(s1, s2, "Serialization should not break Fixed Singleton");
	}

	// --- Enum Singleton (Unbreakable) ---
	@Test
	void testEnumSingletonAlwaysSame() throws Exception {
		EnumSingleton s1 = EnumSingleton.INSTANCE;
		EnumSingleton s2 = EnumSingleton.INSTANCE;
		assertSame(s1, s2, "Enum Singleton is always safe");
	}
}
