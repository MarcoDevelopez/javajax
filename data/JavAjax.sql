USE [JavAjax]
GO
/****** Object:  Table [dbo].[Groups]    Script Date: 09/28/2015 01:09:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Groups](
	[GroupId] [int] NOT NULL,
	[Name] [varchar](80) NULL,
 CONSTRAINT [PK_Groups] PRIMARY KEY CLUSTERED 
(
	[GroupId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Groups] ([GroupId], [Name]) VALUES (1, N'Family')
INSERT [dbo].[Groups] ([GroupId], [Name]) VALUES (2, N'Friends')
INSERT [dbo].[Groups] ([GroupId], [Name]) VALUES (3, N'Work')
INSERT [dbo].[Groups] ([GroupId], [Name]) VALUES (4, N'University')
INSERT [dbo].[Groups] ([GroupId], [Name]) VALUES (5, N'Adventures')
/****** Object:  Table [dbo].[Contacts]    Script Date: 09/28/2015 01:09:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Contacts](
	[ContactId] [int] NOT NULL,
	[Photo] [varchar](200) NULL,
	[FirstName] [varchar](80) NULL,
	[LastName] [varchar](80) NULL,
	[BirthDate] [date] NULL,
	[Email] [varchar](50) NULL,
	[Active] [bit] NULL,
	[GroupId] [int] NULL,
 CONSTRAINT [PK_Contacts] PRIMARY KEY CLUSTERED 
(
	[ContactId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Contacts] ([ContactId], [Photo], [FirstName], [LastName], [BirthDate], [Email], [Active], [GroupId]) VALUES (1, N'', N'Marco', N'López', CAST(0xB5160B00 AS Date), N'mlopezdev@gmail.com', 0, 1)
INSERT [dbo].[Contacts] ([ContactId], [Photo], [FirstName], [LastName], [BirthDate], [Email], [Active], [GroupId]) VALUES (2, N'', N'Hernesto', N'López', CAST(0x29120B00 AS Date), N'jhlopez24@gmail.com', 1, 2)
INSERT [dbo].[Contacts] ([ContactId], [Photo], [FirstName], [LastName], [BirthDate], [Email], [Active], [GroupId]) VALUES (3, N'', N'Alex', N'Garcia', CAST(0x03140B00 AS Date), N'agarciagatica@gmail.com', 1, 3)
INSERT [dbo].[Contacts] ([ContactId], [Photo], [FirstName], [LastName], [BirthDate], [Email], [Active], [GroupId]) VALUES (4, N'', N'Miguel', N'Ángeles', CAST(0x5C0B0B00 AS Date), N'mangeles@ixoye.com.pe', 1, 3)
INSERT [dbo].[Contacts] ([ContactId], [Photo], [FirstName], [LastName], [BirthDate], [Email], [Active], [GroupId]) VALUES (5, N'', N'Fanni', N'López', CAST(0x21120B00 AS Date), N'flopez@bethelradio.fm', 1, 4)
INSERT [dbo].[Contacts] ([ContactId], [Photo], [FirstName], [LastName], [BirthDate], [Email], [Active], [GroupId]) VALUES (6, N'', N'Edison', N'Moya', CAST(0x5E080B00 AS Date), N'edisomoya@hotmail.com', 1, 4)
INSERT [dbo].[Contacts] ([ContactId], [Photo], [FirstName], [LastName], [BirthDate], [Email], [Active], [GroupId]) VALUES (7, N'', N'Leeidy', N'Huamanchaqui', CAST(0x9A160B00 AS Date), N'leeidy_h@hotmail.com', 1, 1)
/****** Object:  ForeignKey [FK_Contacts_Groups]    Script Date: 09/28/2015 01:09:54 ******/
ALTER TABLE [dbo].[Contacts]  WITH CHECK ADD  CONSTRAINT [FK_Contacts_Groups] FOREIGN KEY([GroupId])
REFERENCES [dbo].[Groups] ([GroupId])
GO
ALTER TABLE [dbo].[Contacts] CHECK CONSTRAINT [FK_Contacts_Groups]
GO
