package edu.vuum.mocca;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

/**
 * @class SimpleAtomicLong
 *
 * @brief This class implements a subset of the
 *        java.util.concurrent.atomic.SimpleAtomicLong class using a
 *        ReentrantReadWriteLock to illustrate how they work.
 */
class SimpleAtomicLong
{
    /**
     * The value that's manipulated atomically via the methods.
     */
    private long mValue;
    
    /**
     * The ReentrantReadWriteLock used to serialize access to mValue.
     */

    // TODO -- you fill in here by replacing the null with an
    // initialization of ReentrantReadWriteLock.
    private ReentrantReadWriteLock mRWLock = new ReentrantReadWriteLock();
    private final Lock wlock;
    private final Lock rlock;

    /**
     * Creates a new SimpleAtomicLong with the given initial value.
     */
    public SimpleAtomicLong(long initialValue)
    {
        // TODO -- you fill in here
    	wlock = mRWLock.writeLock();
    	rlock = mRWLock.readLock();
    	
    	wlock.lock();
    	this.mValue = initialValue;
    	wlock.unlock();
    	
    }

    /**
     * @brief Gets the current value.
     * 
     * @returns The current value
     */
    public long get()
    {
        long value;

         
        // TODO -- you fill in here;
        rlock.lock();
        value = this.mValue;
        rlock.unlock();

        return value;
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the updated value
     */
    public long decrementAndGet()
    {
        long value = 0;

        // TODO -- you fill in here
        try
        {
	        wlock.lock();
	        this.mValue--;
	        value = mValue;
        }
        finally
        {
        	wlock.unlock();	
        }
        return value;
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the previous value
     */
    public long getAndIncrement()
    {
        long value = 0;

        // TODO -- you fill in here
        try
        {
	        wlock.lock();
	        value = this.get();
	        this.mValue++;
        }
        finally 
        {
        	wlock.unlock();
        }
                
        return value;
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the previous value
     */
    public long getAndDecrement()
    {
        long value = 0;

        // TODO -- you fill in here
        try
        {
	        wlock.lock();
	        value = mValue;
	        this.mValue--;
    	}
        finally
        {
        	wlock.unlock();
        }
        return value;
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the updated value
     */
    public long incrementAndGet()
    {
        long value = 0;

        // TODO -- you fill in here
        try
        {
	        wlock.lock();
	        this.mValue++;
	        value = mValue;	        
        }
        finally
        {
        	wlock.unlock();
        }
        return value;
    }
}

