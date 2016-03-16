package sun.test.spring.model.impl;

import sun.test.spring.model.Contestant;

/**
 * Created by sun on 16/03/16.
 */
public class GraciousContestant implements Contestant
{
    @Override
    public void contest()
    {
        System.out.println("I am a gracious contestant...");
    }
}
