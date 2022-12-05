defmodule Erliex.Escape do
  @moduledoc """
  本模块用于 html，javascript escape
  """

  import Erliex.Util

  @doc """
  根据配置动态决定escape的内容
  either_do(input, condition, funcdoiftrue, funcfalsedo)
  """
  def escape(content) do
    escape_types = %{
      "escape_html" => true,
      "escape_js" => true
    }

    content
    |> either_do(Map.get(escape_types, "escape_html", false), &html_escape(&1))
    |> either_do(Map.get(escape_types, "escape_js", false), &javascript_escape(&1))
  end

  @doc """
  " is replaced with &quot;
  & is replaced with &amp;
  < is replaced with &lt;
  > is replaced with &gt;
  ' is replaced with &#39;
  """
  def html_escape(content) do
    cond do
      String.valid?(content) ->
        escape_char(
          content
          |> String.to_charlist(),
          ""
        )
      is_list(content) ->
        escape_char(
          content
          |> List.to_charlist(),
          ""
        )
      true ->
        ""
    end
  end

  @doc """
  9  Horizontal Tab is replaced with \t
  11 Vertical Tab is replaced with \v
  0  Nul char is replaced with \0
  8  Backspace is replaced with \b
  12 Form feed is replaced with \f
  10 Newline is replaced with \n
  13 Carriage return is replaced with \r
  39 Single quote is replaced with \'
  34 Double quote is replaced with \"
  92 Backslash is replaced with \\
  """
  def javascript_escape(content) do
    cond do
      String.valid?(content) ->
        js_escape_char(
          content
          |> String.to_charlist(),
          ""
        )
      is_list(content) ->
        js_escape_char(
          content
          |> List.to_charlist(),
          ""
        )
      true ->
        ""
    end
  end

  @doc """
  %% @doc
  %% 0: null
  %% 10: LF
  %% 13: CR
  %% 92: \
  %% 39: '
  %% 34: "
  %% 26: SUB
  """
  def sql_escape(content) do
    cond do
      String.valid?(content) ->
        sql_escape_char(
          content
          |> String.to_charlist(),
          ""
        )
      is_list(content) ->
        sql_escape_char(
          content
          |> List.to_charlist(),
          ""
        )
      true ->
        ""
    end
  end

  @doc """
  javascript escape
  """
  def js_escape_char([?\t | rest], acc) do
    js_escape_char(rest, acc <> "\t")
  end
  def js_escape_char([?\v | rest], acc) do
    js_escape_char(rest, acc <> "\v")
  end
  def js_escape_char([?\0 | rest], acc) do
    js_escape_char(rest, acc <> "\0")
  end
  def js_escape_char([?\b | rest], acc) do
    js_escape_char(rest, acc <> "\b")
  end
  def js_escape_char([?\f | rest], acc) do
    js_escape_char(rest, acc <> "\f")
  end
  def js_escape_char([?\n | rest], acc) do
    js_escape_char(rest, acc <> "\n")
  end
  def js_escape_char([?\r | rest], acc) do
    js_escape_char(rest, acc <> "\r")
  end
  def js_escape_char([?' | rest], acc) do
    js_escape_char(rest, acc <> "\'")
  end
  def js_escape_char([?" | rest], acc) do
    js_escape_char(rest, acc <> "\"")
  end
  def js_escape_char([?\\ | rest], acc) do
    js_escape_char(rest, acc <> "\\")
  end
  def js_escape_char([char | rest], acc) do
    js_escape_char(rest, acc <> List.to_string([char]))
  end
  def js_escape_char([], acc) do
    acc
  end

  @doc """
  html entity escape
  """
  def escape_char([?< | rest], acc) do
    escape_char(rest, acc <> "&lt;")
  end
  def escape_char([?> | rest], acc) do
    escape_char(rest, acc <> "&gt;")
  end
  def escape_char([?& | rest], acc) do
    escape_char(rest, acc <> "&amp;")
  end
  def escape_char([?" | rest], acc) do
    escape_char(rest, acc <> "&quot;")
  end
  def escape_char([?' | rest], acc) do
    escape_char(rest, acc <> "&#39;")
  end
  def escape_char([char | rest], acc) do
    escape_char(rest, acc <> List.to_string([char]))
  end
  def escape_char([], acc) do
    acc
  end

  @doc """
  sql escape
  """
  def sql_escape_char([?\0 | rest], acc) do
    escape_char(rest, acc <> "\0")
  end
  def sql_escape_char([?\n | rest], acc) do
    escape_char(rest, acc <> "\n")
  end
  def sql_escape_char([?\r | rest], acc) do
    escape_char(rest, acc <> "\r")
  end
  def sql_escape_char([?\\ | rest], acc) do
    escape_char(rest, acc <> "\\")
  end
  def sql_escape_char([?' | rest], acc) do
    escape_char(rest, acc <> "\'")
  end
  def sql_escape_char([?" | rest], acc) do
    escape_char(rest, acc <> "\"")
  end
  def sql_escape_char([], acc) do
    acc
  end
end