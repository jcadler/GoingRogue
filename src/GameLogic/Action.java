public abstract class Action
{
    private int timer;
    private Range r;

    public abstract void act(Creature c);
    public Creature actOnClone(Creature c)
    {
	Creature clone = c.Clone();
	act(clone);
	return clone;
    }
    public void decrementTimer()
    {
	timer--;
    }
}