defmodule ErliexTest do
  use ExUnit.Case
  doctest Erliex

  test "greets the world" do
    assert Erliex.hello() == :world
  end
end
