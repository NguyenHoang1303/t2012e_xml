<?controller version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <xsl:template match="/">
        <html>
            <head>
                <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
                      rel="stylesheet"/>
            </head>
            <body>
                <h2>My CD Collection</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>Title</th>
                        <th>Artist</th>
                    </tr>
                    <xsl:for-each select="catalog/cd">
                        <xsl:apply-templates select="myCD"/>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="myCD">
        <tr>
            <td>
                <xsl:value-of select="title"/>
            </td>
            <td>
                <xsl:value-of select="artist"/>
            </td>
            <td>
                <xsl:value-of select="country"/>
            </td>
            <td>
                <xsl:value-of select="company"/>
            </td>
            <xsl:apply-templates select="priceAndYear"/>
        </tr>
    </xsl:template>

    <xsl:template match="priceAndYear">
        <xsl:if test="price &lt; 9">
            <td>
                <xsl:value-of select="price"/>
                <i style="color: red" class="fas fa-tags"/>
            </td>
        </xsl:if>
        <xsl:if test="price &gt;= 9">
            <td>
                <xsl:value-of select="price"/>
            </td>
        </xsl:if>
        <xsl:if test="year &gt;= 1995 ">
            <td>
                <xsl:value-of select="year"/>
                <i style="color: green" class="fas fa-arrow-down"/>
            </td>
        </xsl:if>
        <xsl:if test="year &lt; 1995 ">
            <td>
                <xsl:value-of select="year"/>
            </td>
        </xsl:if>
    </xsl:template>

</xsl:stylesheet>