package main

import (
  "os"
  "strings"
  "fmt"
  "strconv"
)

const FILE = "input.txt"

func parse(filename string) []string{
  b, err := os.ReadFile(filename)
  if(err != nil){
    panic(err)
  }
  return strings.Split(string(b), "\n")
}

func main(){
  data := parse(FILE)
  values := make([]int, 0)
  for _, v := range data{
    value, _ := strconv.Atoi(v)
    values = append(values, value)
  }
  res1 := 0
  for i := range values{
    if(i > 0){
      if(values[i] > values[i-1]){
        res1 += 1
      }
    }
  }
  fmt.Println(res1)
  res2 := 0
  windows := make([]int, 0)
  for i := range values{
    if(i + 2 < len(values)){
      windows = append(windows, values[i] + values[i + 1] + values[i + 2])
    }
  }
  for i := range windows{
    if(i > 0){
      if(windows[i] > windows[i-1]){
        res2 += 1
      }
    }
  }
  fmt.Println(res2)
}
