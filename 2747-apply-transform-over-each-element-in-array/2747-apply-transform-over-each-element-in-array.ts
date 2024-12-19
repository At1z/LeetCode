function map(arr: number[], fn: (n: number, i: number) => number): number[] {
    const mappedArray: number[] = [];
    for(let i = 0; i < arr.length; i++){
        mappedArray.push(fn(arr[i],i));
    }
    return mappedArray;
};