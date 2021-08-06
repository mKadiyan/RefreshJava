package com.learn.concurrency;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import com.learn.common.ThreadSafe;

@ThreadSafe
public class CountingFactorizer {
  private final AtomicReference<BigInteger> lastNumber
      = new AtomicReference<BigInteger>();
  private final AtomicReference<BigInteger[]>  lastFactors
      = new AtomicReference<BigInteger[]>();
  private final AtomicLong count = new AtomicLong(0);

  public long getCount(long val) {
    BigInteger i = BigInteger.valueOf(val);
    if (i.equals(lastNumber.get()))
      return lastNumber.get().longValue();
    else {
      lastNumber.set(i);
      lastFactors.set(null);
    }
    callMe();
    return val;
  }

  public void callMe() {
    count.incrementAndGet();

  }
}