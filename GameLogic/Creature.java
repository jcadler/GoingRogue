public abstract class Creature
{
    private Point2D _pos;
    private List<Attribute> attributes;

    public getPosition();
    public setPosition();
    public void incurDamage(int damage);
    public int getHealth();
    public List<Attribute> getAttributes()
    {
	return attributes;
    }
}