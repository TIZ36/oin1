defmodule Erliex.Util do

  @doc """
  三元执行函数
  """
  def either_do(input, condition, fun_true, func_false \\ &(&1)) do
    if condition do
      input
      |> fun_true.()
    else
      input
      |> func_false.()
    end
  end

  @doc """
  按一定的长度分割list
  """
  def chunk_every(list, size) do
    Enum.chunk_every(list, size)
  end
end