struct numbers{
    int a;
    int b;
};


program CALC_PROG{
    version CALC_VERS {
        int add(numbers) = 1;

        int sub(numbers) = 2;

        int mult(numbers) = 3;

        int divide(numbers) = 4;
    } = 1;
} = 0x20000001;