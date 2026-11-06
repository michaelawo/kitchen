package kitchen.meals;

public class Meal{
    private final String name;
    private final MealType type;
    private boolean isFinished;

    public String getName(){
        return this.name;
    }

    public MealType getType(){
        return this.type;
    }

    public Meal(String name, MealType type){
        if(name.isEmpty() || name == null || type == null){
            throw new IllegalArgumentException("Invalid name or type");
        }

        this.name = name;
        this.type = type;
        this.isFinished = false;
    }

    public void setFinished(boolean isFinished){
        this.isFinished = isFinished;
    }

    public boolean isFinished(){
        return this.isFinished;
    }
}