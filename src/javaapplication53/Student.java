

class Student {
    private String name;
    private int age;
    private String id;
    private String email;
    private String course;

    public Student(String name, int age, String id, String email, String course) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.email = email;
        this.course = course;
    }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }
}